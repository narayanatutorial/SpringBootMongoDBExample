package com.narayanatutorial.SpringBootMongoDBExample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public long updateCity(String name,String city) {
		Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("city", city);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Employee.class);

        if(result!=null)
            return result.getModifiedCount();
        else
            return 0;

	}
	
	

}
