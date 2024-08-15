package com.fresh.coding.hackback.dtos.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class PageInfo implements Serializable {
    private Boolean hasNext;
    private Boolean hasPrevious;
}
