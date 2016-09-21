package projects.almeida.fernando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.almeida.fernando.model.CommerceItem;
import projects.almeida.fernando.repository.CommerceItemRepository;

@Service
public class CommerceItemService {

    @Autowired
    private CommerceItemRepository commerceItemRepository;
    
    @Transactional
    public void delete(String id){
	commerceItemRepository.delete(id);
    }
    
    @Transactional
    public void save(CommerceItem commerceItem){
	commerceItemRepository.save(commerceItem);
    }
}
