package com.haziq.crbs.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.haziq.crbs.common.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public abstract class GenericService<T extends GenericEntity<T>> {
    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage (PagingRequest pagingRequest){
        final GenericSpecification<T> specification = new GenericSpecification<>(pagingRequest);
        final Pageable pageable = PageRequest.of(pagingRequest.getPage(), pagingRequest.getLength());
        return repository.findAll(specification, pageable);
    }

    public T get(Long id ) throws ObjectNotFoundException {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    @Transactional
    public T create(T newDomain) {
        T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public T update(Long id, T updated) throws ObjectNotFoundException {
        T dbDomain = get(id);
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public void delete (Long id ) throws ObjectNotFoundException{
        this.get(id);
        repository.deleteById(id);
    }

    public void deleteBulk(List<Long> ids) {
        repository.deleteAllById(ids);
    }
}
