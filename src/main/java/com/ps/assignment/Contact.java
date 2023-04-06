package com.ps.assignment;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contact {
    private String name;
    private String mobile;
    private String catalogue;
}
