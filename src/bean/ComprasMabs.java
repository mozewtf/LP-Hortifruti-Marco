package bean;
// Generated 22/09/2023 19:10:28 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComprasMabs generated by hbm2java
 */
@Entity
@Table(name="compras_mabs"
    ,catalog="horifrutibutarellilp"
)
public class ComprasMabs  implements java.io.Serializable {


     private int idComprasMabs;
     private FornecedorMabs fornecedorMabs;
     private ProdutosMabs produtosMabs;
     private String quantidadeMabs;
     private Double totalMabs;
     private Double valorunitariomabs;
     private ClienteMabs clienteMabs;
  

    public ComprasMabs() {
    }

	
    public ComprasMabs(int idComprasMabs, FornecedorMabs fornecedorMabs, ProdutosMabs produtosMabs, String quantidadeMabs, Double totalMabs, Double valorunitarioMabs, ClienteMabs clienteMabs) {
        this.idComprasMabs = idComprasMabs;
        this.fornecedorMabs = fornecedorMabs;
        this.produtosMabs = produtosMabs;
        this.quantidadeMabs = quantidadeMabs;
        this.totalMabs = totalMabs;
        this.valorunitariomabs = valorunitarioMabs;
        this.clienteMabs = clienteMabs;
    }
    public ComprasMabs(int idComprasMabs, FornecedorMabs fornecedorMabs, ProdutosMabs produtosMabs, String quantidadeMabs, Double totalMabs, Double valorunitarioMabs ,Set comprasProdutoMabses, ClienteMabs clienteMabs) {
       this.idComprasMabs = idComprasMabs;
       this.fornecedorMabs = fornecedorMabs;
       this.produtosMabs = produtosMabs;
       this.quantidadeMabs = quantidadeMabs;
       this.totalMabs = totalMabs;
       this.valorunitariomabs = valorunitarioMabs;
       this.clienteMabs = clienteMabs;
    }
   
     @Id 

    
    @Column(name="id_compras_mabs", unique=true, nullable=false)
    public int getIdComprasMabs() {
        return this.idComprasMabs;
    }
    
    public void setIdComprasMabs(int idComprasMabs) {
        this.idComprasMabs = idComprasMabs;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fkfornecedor_mabs", nullable=false)
    public FornecedorMabs getFornecedorMabs() {
        return this.fornecedorMabs;
    }
    
    public void setFornecedorMabs(FornecedorMabs fornecedorMabs) {
        this.fornecedorMabs = fornecedorMabs;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fkproduto_mabs", nullable=false)
    public ProdutosMabs getProdutosMabs() {
        return this.produtosMabs;
    }
    
    public void setProdutosMabs(ProdutosMabs produtosMabs) {
        this.produtosMabs = produtosMabs;
    }

    
    @Column(name="quantidade_mabs", nullable=false, length=10)
    public String getQuantidadeMabs() {
        return this.quantidadeMabs;
    }
    
    public void setQuantidadeMabs(String quantidadeMabs) {
        this.quantidadeMabs = quantidadeMabs;
    }

    
    @Column(name="total_mabs", nullable=false, precision=5)
    public Double getTotalMabs() {
        return this.totalMabs;
    }
    
    public void setTotalMabs(Double totalMabs) {
        this.totalMabs = totalMabs;
    }

 
    @Column(name="valorunitario_mabs", nullable=false, precision=5)
    public Double getValorunitarioMabs() {
        return this.valorunitariomabs;
    }
    
    public void setValorunitarioMabs(Double valorunitarioMabs) {
        this.valorunitariomabs = valorunitarioMabs;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fkcliente_mabs", nullable=false)
    public ClienteMabs getClienteMabs() {
        return this.clienteMabs;
    }
    
    public void setClienteMabs(ClienteMabs clienteMabs) {
        this.clienteMabs = clienteMabs;
    }




}


