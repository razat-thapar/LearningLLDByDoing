package com.lld.one.h_concurrency_assignment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.ZonedDateTime;
@Getter
@ToString
public class Response {
    private String bikerName;
    private Duration duration;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    public Response(String bikerName, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.startTime = startTime;
        this.bikerName = bikerName;
        this.endTime = endTime;
        this.duration = Duration.between(startTime,endTime);
    }
}
