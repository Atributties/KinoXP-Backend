package com.example.kinoxpbackend.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AgeLimit {
    G,      // General Audiences (All ages are admitted)
    PG,     // Parental Guidance Suggested (Some material may not be suitable for children)
    PG_13,  // Parents Strongly Cautioned (Some material may be inappropriate for children under 13)
    R,      // Restricted (Under 17 requires accompanying parent or adult guardian)
    NC_17   // Adults Only (No one 17 and under admitted)


}