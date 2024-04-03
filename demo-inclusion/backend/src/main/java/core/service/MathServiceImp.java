
package core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.configuration.AppProperties;
import core.exception.AppException;
import core.model.dto.in.RequestKDTO;
import core.model.dto.out.ResultKDTO;
import core.service.validator.IRequestKDTOValidatorService;

/**
 *
 * @author JOrtiz
 */

@Service
public class MathServiceImp implements IMathService {

    private final AppProperties appProperties;
    private final Logger logger = LoggerFactory.getLogger(MathServiceImp.class);

    @Autowired
    private IRequestKDTOValidatorService requestKDTOValidatorServiceImp;

    public MathServiceImp(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public ResultKDTO findTheMaximumIntegerK(RequestKDTO dto) {

        logger.info("Validating numbers...");
        var rv = requestKDTOValidatorServiceImp.validate(dto);
        if (rv.isValid()) {
            final int x = dto.getX();
            final int y = dto.getY();
            final int n = dto.getN();

            logger.info("Doing math...");
            final int k = (n - y) / x * x + y;
            logger.info("App Name: {}", appProperties.getBootstrapServer() + "Maximum k = " + k);

            return new ResultKDTO(k);
        } else {
            logger.info("App Name: {}", "A new ERROR Message " + rv.getResult());
            throw new AppException(rv.getResult(), true);

        }

    }

}
