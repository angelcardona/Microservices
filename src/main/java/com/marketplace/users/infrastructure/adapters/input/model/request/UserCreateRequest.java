package com.marketplace.users.infrastructure.adapters.input.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserCreateRequest {

    @NotBlank(message = "El nombre no puede ser vacio")
    private String name;
    @NotBlank(message = "El apellido no puede ser vacio")
    private String lastName;
    @NotBlank(message = "El correo no puede ser vacio")
    @NotNull(message = "El email es requerido")
    private String email;
    @NotBlank(message = "El pais es requerido")
    private String country;



}
