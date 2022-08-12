package com.refectoring.effectivejava.ref._11_primitive_obsession._03_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class RatingFactory extends ChinaExperienceVoyageRating {

    public RatingFactory(Voyage voyage, List<VoyageHistory> history) {
        super(voyage, history);
    }
}
