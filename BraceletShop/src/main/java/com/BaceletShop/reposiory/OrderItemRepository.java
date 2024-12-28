package com.BaceletShop.reposiory;

import com.BaceletShop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

//    @Transactional
//    @Modifying
//    @Query("update Appointment a set a.date = ?1, a.time = ?2 where a.id = ?3")
//    void updateDateForAppointment(Date date, Time time, Long id);

//    List<OrderItem> findByUser_IdOrderByDateAsc(Long id, Sort sort);

//    List<Appointment> findByPatient_IdOrderByDateDesc(Long id, Sort sort);

//    List<Appointment> findByPatient_IdAndDateGreaterThanOrderByDateDesc(Long id, Date fromDate);

//    List<Appointment> findByPatient_IdAndDateLessThanOrderByDateDesc(Long id, Date toDate);

//    List<Appointment> findByPatient_IdAndDateGreaterThanAndDateLessThanOrderByDateDesc(Long id, Date fromDate, Date toDate);

    // DOCTOR APPOINTMENTS REPOSITORIES ==========================================================

//    List<Appointment> findByDoctor_IdOrderByDateAsc(Long id, Sort sort);

//    List<Appointment> findByDoctor_IdOrderByDateDesc(Long id, Sort sort);

//    List<Appointment> getAppointmentByDoctorId(Long id);

//    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);

}
