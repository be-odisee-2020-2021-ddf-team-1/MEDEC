package be.odisee.medec.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Id;


@Data
@RequiredArgsConstructor
public class Planning {

    @Id
    private final long plannerId;

    private final String name;

}
