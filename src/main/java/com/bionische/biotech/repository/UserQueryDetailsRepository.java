package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.UserQueryDetails;

public interface UserQueryDetailsRepository extends JpaRepository<UserQueryDetails, Integer>{

	
	UserQueryDetails save(UserQueryDetails userQueryDetails);

	List<UserQueryDetails> findByStatusOrderByTicketNoDesc(int status);
	

@Transactional
@Modifying
@Query("UPDATE UserQueryDetails a SET a.reply =:reply, a.status=1, a.replyDate=:dateTime  WHERE a.ticketNo=:ticketNo")
int sendReplyToUserQuery(@Param("ticketNo")int ticketNo, @Param("reply")String reply, @Param("dateTime")String dateTime);

UserQueryDetails findByTicketNo(int ticketNo);
}
