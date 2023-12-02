package tn.esprit.studenthousing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.repositories.BlockRepository;

@Service
@RequiredArgsConstructor
public class IBlockServiceImp implements IBlockService {

    private final BlockRepository blockRepository;

    @Override
    public Block addBlock(Block block) {
        return blockRepository.save(block);
    }
}
