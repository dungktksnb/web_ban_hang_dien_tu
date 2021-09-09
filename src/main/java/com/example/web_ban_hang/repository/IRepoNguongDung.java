package com.example.web_ban_hang.repository;


import com.example.web_ban_hang.model.NguoiDung;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepoNguongDung extends PagingAndSortingRepository<NguoiDung,Long> {
}
