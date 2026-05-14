package br.pucrs.daniellemadrid.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AcervoRepoJdbcImpl implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AcervoRepoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Livro> getLivros() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * FROM livros",
                (rs, rowNum) -> new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
                        rs.getInt("ano")));
        return resp;
    }

    @Override
    public boolean removeLivro(int id) {
        String sql = "DELETE FROM livros WHERE id = " + id;
        this.jdbcTemplate.batchUpdate(sql);
        return true;
    }
}