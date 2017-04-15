
package com.example.infiny.ezrent.DI.component;


import com.example.infiny.ezrent.DI.PerService;
import com.example.infiny.ezrent.DI.module.ServiceModule;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {


}
