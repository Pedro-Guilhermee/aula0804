package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    private long id;
    private String titulo;
    private String descricao;
    private String publicacao; // Data no formato YYYY-MM-DD
    private boolean ativo;
    private long idEmpresa;
}