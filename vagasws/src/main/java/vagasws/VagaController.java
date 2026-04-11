package vagasws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fci/api/vagas")
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>();

    public VagaController() {
        vagas.add(new Vaga(1, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true, 1));
        vagas.add(new Vaga(2, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27", true, 2));
        vagas.add(new Vaga(3, "Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false, 3));
        vagas.add(new Vaga(4, "Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4));
        vagas.add(new Vaga(5, "Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false, 5));
        vagas.add(new Vaga(6, "Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1));
        vagas.add(new Vaga(7, "Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, 2));
    }

    @GetMapping
    public List<Vaga> getVagas() {
        return vagas;
    }

    @GetMapping("/{id}")
    public Vaga getVaga(@PathVariable long id) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    @PostMapping
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        long maiorId = 0;
        for (Vaga v : vagas) {
            if (v.getId() > maiorId) {
                maiorId = v.getId();
            }
        }
        novaVaga.setId(maiorId + 1);
        vagas.add(novaVaga);
        return novaVaga;
    }

    @PutMapping("/{id}")
    public Vaga updateVaga(@PathVariable long id, @RequestBody Vaga dadosAtualizados) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                v.setTitulo(dadosAtualizados.getTitulo());
                v.setDescricao(dadosAtualizados.getDescricao());
                v.setPublicacao(dadosAtualizados.getPublicacao());
                v.setAtivo(dadosAtualizados.isAtivo());
                v.setIdEmpresa(dadosAtualizados.getIdEmpresa());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVaga(@PathVariable long id) {
        vagas.removeIf(v -> v.getId() == id);
    }
}