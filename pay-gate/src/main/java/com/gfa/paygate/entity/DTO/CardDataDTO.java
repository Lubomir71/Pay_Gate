package com.gfa.paygate.entity.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDataDTO {
    @NotNull(message = "name cannot be null")
    @NotEmpty (message = "name cannot be empty")
    private String name;
    @NotNull(message = "number cannot be null")
    @NotEmpty(message = "number cannot be empty")
    @Pattern(regexp = "^[0-9]{16}$", message = "number must have 16 digits")
    private String number;
    @NotNull(message = "valid cannot be null")
    @NotEmpty (message = "valid cannot be empty")
    @Pattern(regexp = "[0-9]{2}+/+[0-9]{2}", message = "valid must have format 'mm/yy'")
    private String valid;
    @NotNull(message = "cvv cannot be null")
    @NotEmpty (message = "cvv cannot be empty")
    @Pattern(regexp = "[0-9]{3}", message = "cvv must have 3 digits")
    private String cvv;
}
