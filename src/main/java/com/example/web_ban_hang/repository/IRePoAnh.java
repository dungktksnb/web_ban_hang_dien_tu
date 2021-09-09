package com.example.web_ban_hang.repository;


import com.example.web_ban_hang.model.Anh;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRePoAnh extends PagingAndSortingRepository<Anh,Long> {
}
