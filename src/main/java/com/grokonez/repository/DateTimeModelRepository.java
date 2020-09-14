package com.grokonez.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grokonez.model.DateTimeModel;

@Repository
public interface DateTimeModelRepository extends CrudRepository<DateTimeModel,Long>{

	List<DateTimeModel> findAllByDateTimeBetween(Date startDate, Date endDate);
	
	@Query("select d from DateTimeModel d where d.dateTime <= :datetime")
	List<DateTimeModel> findAllWithDateTimeBefore(@Param("datetime") Date dateTime);
}
