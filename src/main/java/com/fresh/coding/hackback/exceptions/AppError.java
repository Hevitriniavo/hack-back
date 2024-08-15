package com.fresh.coding.hackback.exceptions;

import java.time.LocalDate;

public record AppError<T>(
        T message,
        LocalDate date,
        int status
) {
}
