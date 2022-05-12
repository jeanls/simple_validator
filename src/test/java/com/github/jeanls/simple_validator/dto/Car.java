package com.github.jeanls.simple_validator.dto;

import java.math.BigDecimal;

public class Car {
    private String manufacturer;

    private String licensePlate;

    private double price;

    private BigDecimal priceBg;

    private long lifeTime;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private int seatCount;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getPriceBg() {
        return priceBg;
    }

    public void setPriceBg(BigDecimal priceBg) {
        this.priceBg = priceBg;
    }

    public long getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(long lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
