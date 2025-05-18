package org.akshay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SplitAmount {
    User user;
    float amount;
}
