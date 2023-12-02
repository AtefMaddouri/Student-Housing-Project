package tn.esprit.studenthousing.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.services.IBlockService;
import tn.esprit.studenthousing.services.IBlockServiceImp;

@Tag(name = "Block Management")
@RestController
@RequestMapping("block")
@RequiredArgsConstructor
public class BlockRestConroller {

    private final IBlockService blockService;

    @Operation(description = "Add Block")
    @PostMapping
    public Block createBlock(@RequestBody Block block) {
        return blockService.addBlock(block);
    }

}
