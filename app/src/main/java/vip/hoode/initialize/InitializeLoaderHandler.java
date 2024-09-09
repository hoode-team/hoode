package vip.hoode.initialize;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class InitializeLoaderHandler {

    private final List<InitializeLoader> initializeLoaders;

    @EventListener
    public void onReady(ApplicationReadyEvent event) {
        initializeLoaders.forEach(it -> {
            if (it.hasInitialized()) {
                it.initialize();
            }
        });
    }

}
