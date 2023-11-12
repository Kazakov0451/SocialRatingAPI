package com.example.socialratingapi.model.dto.point;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointDto {

    /**
     * Идентификатор кому
     */
    private Long toId;
    /**
     * Идентификатор от кого
     */
    private Long fromId;
    /**
     * Количество передаваемых баллов
     */
    private Long points;
}
