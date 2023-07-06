package com.vji.aquaqaapi.repositories;



import com.vji.aquaqaapi.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select external_hum from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyExtHumDataOf(Long userId);

    @Query(value = "select external_temp from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyExtTempDataOf(Long userId);

    @Query(value = "select internal_temp from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyInterTempDataOf(Long userId);

    @Query(value = "select ph_value from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyPhDataOf(Long userId);

    @Query(value = "select tds_value from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyTdsDataOf(Long userId);

    @Query(value = "select tension_value from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyTensionDataOf(Long userId);

    @Query(value = "select ts_value from reports where user_id=:userId order by id desc limit 227",
            nativeQuery = true)
    List<Float> getDailyTsDataOf(Long userId);

    @Query(value = "select external_hum from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyExtHumDataOf(Long userId);

    @Query(value = "select external_temp from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyExtTempDataOf(Long userId);

    @Query(value = "select internal_temp from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyInterTempDataOf(Long userId);

    @Query(value = "select ph_value from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyPhDataOf(Long userId);

    @Query(value = "select tds_value from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyTdsDataOf(Long userId);

    @Query(value = "select tension_value from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyTensionDataOf(Long userId);

    @Query(value = "select ts_value from reports where user_id=:userId order by id desc limit 698",
            nativeQuery = true)
    List<Float> getWeeklyTsDataOf(Long userId);

    @Query(value = "select external_hum from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyExtHumDataOf(Long userId);

    @Query(value = "select external_temp from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyExtTempDataOf(Long userId);

    @Query(value = "select internal_temp from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyInterTempDataOf(Long userId);

    @Query(value = "select ph_value from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyPhDataOf(Long userId);

    @Query(value = "select tds_value from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyTdsDataOf(Long userId);

    @Query(value = "select tension_value from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyTensionDataOf(Long userId);

    @Query(value = "select ts_value from reports where user_id=:userId order by id desc limit 943",
            nativeQuery = true)
    List<Float> getMonthlyTsDataOf(Long userId);

    @Query(value = "select external_hum from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyExtHumDataOf(Long userId);

    @Query(value = "select external_temp from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyExtTempDataOf(Long userId);

    @Query(value = "select internal_temp from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyInterTempDataOf(Long userId);

    @Query(value = "select ph_value from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyPhDataOf(Long userId);

    @Query(value = "select tds_value from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyTdsDataOf(Long userId);

    @Query(value = "select tension_value from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyTensionDataOf(Long userId);

    @Query(value = "select ts_value from reports where user_id=:userId order by id desc limit 1057",
            nativeQuery = true)
    List<Float> getYearlyTsDataOf(Long userId);

}
