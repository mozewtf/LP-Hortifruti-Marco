package bean;
// Generated 22/09/2023 19:10:28 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * ComprasProdutoMabs generated by hbm2java
 */
@Entity
@Table(name="compras_produto_mabs"
    ,catalog="horifrutibutarellilp"
)
public class ComprasProdutoMabs  implements java.io.Serializable {


     private int idComprasProdutoMabs;
     private ComprasMabs comprasMabs;
     private ProdutosMabs produtosMabs;
     private int quantidadeMabs;
     private Double valorunitarioMabs;

    public ComprasProdutoMabs() {
    }

    public ComprasProdutoMabs(int idComprasProdutoMabs, ComprasMabs comprasMabs, ProdutosMabs produtosMabs, int quantidadeMabs, Double valorunitarioMabs) {
       this.idComprasProdutoMabs = idComprasProdutoMabs;
       this.comprasMabs = comprasMabs;
       this.produtosMabs = produtosMabs;
       this.quantidadeMabs = quantidadeMabs;
       this.valorunitarioMabs = valorunitarioMabs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_compras_produto_mabs", unique=true, nullable=false)
    public int getIdComprasProdutoMabs() {
        return this.idComprasProdutoMabs;
    }
    
    public void setIdComprasProdutoMabs(int idComprasProdutoMabs) {
        this.idComprasProdutoMabs = idComprasProdutoMabs;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fkcompras_mabs", nullable=false)
    public ComprasMabs getComprasMabs() {
        return this.comprasMabs;
    }
    
    public void setComprasMabs(ComprasMabs comprasMabs) {
        this.comprasMabs = comprasMabs;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fkprodutos_mabs", nullable=false)
    public ProdutosMabs getProdutosMabs() {
        return this.produtosMabs;
    }
    
    public void setProdutosMabs(ProdutosMabs produtosMabs) {
        this.produtosMabs = produtosMabs;
    }

    
    @Column(name="quantidade_mabs", nullable=false)
    public int getQuantidadeMabs() {
        return this.quantidadeMabs;
    }
    
    public void setQuantidadeMabs(int quantidadeMabs) {
        this.quantidadeMabs = quantidadeMabs;
    }

    
    @Column(name="valorunitario_mabs", nullable=false, precision=5)
    public Double getValorunitarioMabs() {
        return this.valorunitarioMabs;
    }
    
    public void setValorunitarioMabs(Double valorunitarioMabs) {
        this.valorunitarioMabs = valorunitarioMabs;
    }




}


