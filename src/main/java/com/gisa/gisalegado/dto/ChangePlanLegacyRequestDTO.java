package com.gisa.gisalegado.dto;

import com.gisa.gisacore.dto.BasicTransactionRequestDTO;
import lombok.Getter;

@Getter
public class ChangePlanLegacyRequestDTO extends BasicTransactionRequestDTO {

    private Long idAssociado;
    private String planoId;

    public ChangePlanLegacyRequestDTO(Long transactionId, Long idAssociado, String planoId) {
        super(transactionId);
        this.idAssociado = idAssociado;
        this.planoId = planoId;
    }
}
