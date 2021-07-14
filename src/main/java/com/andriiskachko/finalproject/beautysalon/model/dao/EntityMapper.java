package com.andriiskachko.finalproject.beautysalon.model.dao;

import java.sql.ResultSet;

/**
 * Defines general contract for mapping database result set rows to application entities.
 */
public interface EntityMapper<T> {
    T mapRow(ResultSet rs);
}