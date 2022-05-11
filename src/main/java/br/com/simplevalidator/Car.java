package br.com.simplevalidator;

import java.math.BigDecimal;

public class Car {
    private final String manufacturer;

    private final String licensePlate;

    private double price;

    private BigDecimal priceBg;

    private long lifeTime;

    private final int seatCount;

    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

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
}
