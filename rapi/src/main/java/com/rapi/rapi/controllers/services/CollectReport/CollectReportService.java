package com.rapi.rapi.controllers.services.CollectReport;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapi.rapi.controllers.DTO.CollectReport.CollectreportSDTO;
import com.rapi.rapi.models.CollectReport.CollectreportEntity;
import com.rapi.rapi.models.CollectReport.CollectreportRepo;

@Service
public class CollectReportService {

    @Autowired
    private CollectreportRepo repo;

    public CollectreportEntity RegisterReport(CollectreportSDTO report)
    {
        CollectreportEntity entity = new CollectreportEntity(report);
        return repo.save(entity);
    }

    public CollectreportEntity GetReport(Long id)
    {
        Optional<CollectreportEntity> search = repo.findById(id);
        return search.get();
    }

    public Boolean UpdateReport(CollectreportSDTO report)
    {
        CollectreportEntity entity = new CollectreportEntity(report);
        CollectreportEntity update = repo.save(entity);
        if(entity.equals(update))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
}
