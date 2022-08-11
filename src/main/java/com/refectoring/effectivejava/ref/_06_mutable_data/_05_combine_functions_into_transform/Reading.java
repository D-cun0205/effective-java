package com.refectoring.effectivejava.ref._06_mutable_data._05_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public record Reading(String customer, double quantity, Month month, Year year) { }
