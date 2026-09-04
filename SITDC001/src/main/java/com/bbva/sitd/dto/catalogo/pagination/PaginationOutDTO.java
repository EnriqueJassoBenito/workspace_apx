package com.bbva.sitd.dto.catalogo.pagination;

import java.io.Serializable;
import java.util.Objects;

public class PaginationOutDTO implements Serializable {	
	private static final long serialVersionUID = -3943499007139894070L;
	
    private ReferencesDTO references;
    
    private Long page;
    private Long totalPages;
    private Long totalElements;
    private Long pageSize;
    
	public ReferencesDTO getReferences() {
		return references;
	}
	public void setReferences(ReferencesDTO references) {
		this.references = references;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public int hashCode() {
		return Objects.hash(page, pageSize, references, totalElements, totalPages);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginationOutDTO other = (PaginationOutDTO) obj;
		return Objects.equals(page, other.page) && Objects.equals(pageSize, other.pageSize)
				&& Objects.equals(references, other.references) && Objects.equals(totalElements, other.totalElements)
				&& Objects.equals(totalPages, other.totalPages);
	}
    

}
