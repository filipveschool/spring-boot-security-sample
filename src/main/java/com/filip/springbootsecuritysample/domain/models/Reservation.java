package com.filip.springbootsecuritysample.domain.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@ApiModel("Reservation data")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "ID of a reservation", example = "1", readOnly = true)
    private Long id;

    @Column(name = "date")
    @ApiModelProperty(value = "The date and time that the reservation was created", example = "2018-06-06 13:02:38")
    private LocalDateTime dt;

    @Column(name = "user_id")
    @ApiModelProperty(value = "The id belonging to the user. This is normally a foreign key linked to the users table", example = "100" ,required = true)
    private Long userId;

    @Column(name = "restaurant_id")
    @ApiModelProperty(value = "The id that belongs to a restaurant. " +
            "This is normally a foreign key linked to the restaurants table", example = "800", required = true)
    private Long restaurantId;

    // Hibernate will convert camel case column names to snake case!!!
    // Don't use camelcase columns in DB
    @Column(name = "party_size")
    @ApiModelProperty(value = "How many people will there come on this reservation?", example = "12", required = true)
    private int partySize;

    public Reservation() {

        dt = LocalDateTime.now();

    }

    public Reservation(Long userId, int partySize) {
        this.userId = userId;
        this.partySize = partySize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}