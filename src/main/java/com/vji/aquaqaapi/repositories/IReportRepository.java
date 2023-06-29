package com.vji.aquaqaapi.repositories;



import com.vji.aquaqaapi.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select external_hum from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyExtHumDataOf(Long userId);

    @Query(value = "select external_temp from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyExtTempDataOf(Long userId);

    @Query(value = "select internal_temp from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyInterTempDataOf(Long userId);

    @Query(value = "select ph_value from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyPhDataOf(Long userId);

    @Query(value = "select tds_value from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyTdsDataOf(Long userId);

    @Query(value = "select tension_value from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyTensionDataOf(Long userId);

    @Query(value = "select ts_value from reports where user_id=:userId order by id desc limit 288",
            nativeQuery = true)
    List<Float> getDailyTsDataOf(Long userId);



}
