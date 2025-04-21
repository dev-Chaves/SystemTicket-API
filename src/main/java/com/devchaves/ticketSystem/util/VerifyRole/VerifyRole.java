package com.devchaves.ticketSystem.util.VerifyRole;

import java.nio.file.AccessDeniedException;

public interface VerifyRole<S,T> {

    T checker (S source) throws AccessDeniedException;

}
