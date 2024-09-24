package com.example.fifotech.services.admin.FAQ;

import com.example.fifotech.dto.FAQDto;

public interface FAQService {

    FAQDto postFAQ(Long productId, FAQDto faqDto);


}
