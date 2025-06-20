package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MtRestaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MtRestaurantRepositoryImpl implements MtRestaurantRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(MtRestaurant r) {

		String sql =
				" INSERT INTO m_restaurant " +
				" (restaurant_name, catch_phrase) " +
				" VALUES (?, ?) ";	

		jdbcTemplate.update(sql, 
				r.getRestaurantName(),
				r.getCatchPhrase()			);
		
	}

	@Override
	public List<MtRestaurant> selectByNameWildcard(String restaurantName) {

		String sql = 
				" SELECT                                                 " + 
				"   mr.restaurant_id,                                    " +
				"   mr.restaurant_name,                                  " +
				"   mr.catch_phrase,                                     " +
				"   COUNT(tr.rating) rating_cnt                          " +
				" FROM                                                   " +
				"  	m_restaurant mr                                      " +
				"  	LEFT OUTER JOIN t_review tr                          " +
				"  	             ON mr.restaurant_id = tr.restaurant_id  " +
				" WHERE                                                  " +
				"  	mr.restaurant_name LIKE ?                            " +
				" GROUP BY                                               " +
				"  	mr.restaurant_id,                                    " +
				"  	mr.restaurant_name,                                  " +
				"  	mr.catch_phrase                                      " +
				" ORDER BY                                               " +
				"   mr.restaurant_id                                     ";

		String p = "%" + restaurantName + "%";	// プレースホルダの値
		
		// SQLで検索（プレースホルダ：p）
		List<Map<String, Object>> list 
				= jdbcTemplate.queryForList(sql, p);
		
		// 値の取得⇒結果の格納
		List<MtRestaurant> result = new ArrayList<MtRestaurant>(); // 結果の初期化
		for (Map<String, Object> one : list) {
			MtRestaurant r = new MtRestaurant();
			r.setRestaurantId((int)one.get("restaurant_id"));
			r.setRestaurantName((String)one.get("restaurant_name"));
			r.setCatchPhrase((String)one.get("catch_phrase"));
			r.setReviewCnt(((Long)one.get("rating_cnt")).intValue());
			result.add(r);
		}

		return result;
	}

	@Override
	public void update(MtRestaurant r) {

		String sql =
				" UPDATE                  " + 
				"   m_restaurant          " + 
				" SET                     " + 
				"   restaurant_name = ? , " + 
				"   catch_phrase = ?      " + 
				" WHERE                   " + 
				"   restaurant_id = ?     ";
		
		jdbcTemplate.update(sql, 
							r.getRestaurantName(),
							r.getCatchPhrase(),
							r.getRestaurantId()		);
		
	}

	@Override
	public void delete(MtRestaurant r) {

		String sql =
				" DELETE              " + 
				" FROM                " + 
				"   m_restaurant      " + 
				" WHERE               " + 
				"   restaurant_id = ? "; 

		jdbcTemplate.update(sql, r.getRestaurantId());
		
	}

}
