package demo;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class WatchServiceDemo {


    public void watchServiceTest() throws IOException {
        String path = "d:/test";
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path p = Paths.get(path);
        p.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);
        ThreadPool.INSTANCE.getInstance().schedule(() -> {
            try {
                while(true){
                    WatchKey watchKey = watchService.take();
                    List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                    for(WatchEvent<?> event : watchEvents){
                        //TODO 根据事件类型采取不同的操作。。。。。。。
                        System.out.println("["+path+"/"+event.context()+"]文件发生了["+event.kind()+"]事件");
                    }
                    watchKey.reset();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, TimeUnit.SECONDS);
    }
}
