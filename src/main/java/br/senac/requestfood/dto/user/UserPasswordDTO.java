package br.senac.requestfood.dto.user;

public record UserPasswordDTO(Long id, String currentPassword, String newPassword, String confirmPassword) {}
