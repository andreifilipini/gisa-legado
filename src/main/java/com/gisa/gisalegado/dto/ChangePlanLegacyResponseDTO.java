package com.gisa.gisalegado.dto;

import com.gisa.gisacore.dto.BasicTransactionResponseDTO;
import lombok.Getter;

@Getter
public class ChangePlanLegacyResponseDTO extends BasicTransactionResponseDTO {

    private Long idAssociado;
    private String planoId;

    public ChangePlanLegacyResponseDTO(Long transactionId, boolean approved, Long idAssociado, String planoId) {
        super(transactionId, approved);
        this.idAssociado = idAssociado;
        this.planoId = planoId;
    }
}
