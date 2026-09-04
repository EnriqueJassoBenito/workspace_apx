package com.bbva.sitd.dto.catalogo.pagination;

import java.io.Serializable;
import java.util.Objects;

public class PaginationInDTO implements Serializable {
	private static final long serialVersionUID = -4185932716175710366L;
	
	private long paginationKey;
	private long pageSize;
	
	public long getPaginationKey() {
		return paginationKey;
	}
	public void setPaginationKey(long paginationKey) {
		this.paginationKey = paginationKey;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public int hashCode() {
		return Objects.hash(pageSize, paginationKey);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginationInDTO other = (PaginationInDTO) obj;
		return pageSize == other.pageSize && paginationKey == other.paginationKey;
	}
	
	
	
	
	
}
