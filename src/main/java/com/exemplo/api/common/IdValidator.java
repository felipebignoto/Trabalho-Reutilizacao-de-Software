package com.exemplo.api.common;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe utilitária para validação de IDs
 */
public class IdValidator {
    
    /**
     * Valida se um recurso existe pelo ID
     * @param id ID do recurso
     * @param repository Repositório JPA
     * @param resourceName Nome do recurso para mensagem de erro
     * @return O recurso encontrado
     * @throws ResourceNotFoundException se o recurso não for encontrado
     */
    public static <T, ID> T validateResource(ID id, JpaRepository<T, ID> repository, String resourceName) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resourceName, "id", id));
    }
}