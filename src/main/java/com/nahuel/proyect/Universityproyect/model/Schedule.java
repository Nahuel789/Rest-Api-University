package com.nahuel.proyect.Universityproyect.model;

import javax.persistence.*;

/**
 * Class of entity schedule
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "Monday")
    private boolean monday;
    @Column(name = "Tuesday")
    private boolean tuesday;
    @Column(name = "Wednesday")
    private boolean wednesday;
    @Column(name = "Thursday")
    private boolean thursday;
    @Column(name = "Friday")
    private boolean friday;

    /**
     * Parameterless constructor of schedule
     */
    public Schedule() {

    }

    /**
     * @param id        new
     * @param startTime admission schedule
     * @param endTime   discharge schedule
     * @param M         boolean Monday
     * @param T         boolean Tuesday
     * @param W         boolean Wednesday
     * @param TH        boolean Thursday
     * @param F         boolean Friday
     */
    public Schedule(Long id, String startTime, String endTime, boolean M, boolean T, boolean W, boolean TH, boolean F) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.monday = M;
        this.tuesday = T;
        this.wednesday = W;
        this.thursday = TH;
        this.friday = F;
    }

    /**
     * method to obtain the id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * method to set the id
     *
     * @param id long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * method to obtain the shift
     *
     * @return shift
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * method to set the start time
     *
     * @param startTime String
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * method to obtain the end time
     *
     * @return String end time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * method to set the end time
     *
     * @param endTime String
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * method you get if the student attends on Monday
     *
     * @return boolean Monday
     */
    public boolean isMonday() {
        return monday;
    }

    /**
     * method that you set if you attend on Monday
     *
     * @param m boolean Monday
     */
    public void setMonday(boolean m) {
        monday = m;
    }

    /**
     * method you get if the student attends on Tuesday
     *
     * @return boolean Tuesday
     */
    public boolean isTuesday() {
        return tuesday;
    }

    /**
     * method that you set if you attend on Tuesday
     *
     * @param t boolean Tuesday
     */
    public void setTuesday(boolean t) {
        tuesday = t;
    }

    /**
     * method you get if the student attends on Wednesday
     *
     * @return boolean Wednesday
     */
    public boolean isWednesday() {
        return wednesday;
    }

    /**
     * method that you set if you attend on Wednesday
     *
     * @param w boolean Wednesday
     */
    public void setWednesday(boolean w) {
        wednesday = w;
    }

    /**
     * method you get if the student attends on Thursday
     *
     * @return boolean Thursday
     */
    public boolean isThursday() {
        return thursday;
    }

    /**
     * method that you set if you attend on Thursday
     *
     * @param TH boolean Thursday
     */
    public void setThursday(boolean TH) {
        thursday = TH;
    }

    /**
     * method you get if the student attends on Friday
     *
     * @return boolean Friday
     */
    public boolean isFriday() {
        return friday;
    }

    /**
     * method that you set if you attend on Friday
     *
     * @param f boolean Friday
     */
    public void setFriday(boolean f) {
        friday = f;
    }
}
