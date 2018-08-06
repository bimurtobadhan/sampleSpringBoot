package com.bimurto.sampleSpringBoot.api.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String city;
    @NotNull
    private Date dob;
}
