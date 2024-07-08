package com.sathya.repo;

import org.springframework.stereotype.Repository;
import com.sathya.model.JobPost;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {

	List<JobPost> jobs = new ArrayList<>();


}
