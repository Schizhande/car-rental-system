package com.vchizhande.rest_client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RentalDto {

    private Long id;

    @NotNull(message = "is required")
    private Integer currentMileage;

    @NotNull(message = "is required")
    private Double penaltyFee;

    @NotNull(message = "is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date rentDate;

    @NotNull(message = "is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date rentEndDate;

    @NotNull(message = "is required")
    private Double rentFee;

    @FutureOrPresent(message = "date should in future or present")
    @NotNull(message = "is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date returnDate;

    @NotNull(message = "is required")
    private Long customerId;

    @NotNull(message = "is required")
    private Long userId;

    @NotNull(message = "is required")
    private Long vehicleId;

}