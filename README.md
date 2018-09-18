# flowless-mobile-test
JavaFX Mobile App using Flowless, a VirtualFlow layout container.

test app uses:  
'org.fxmisc.flowless:flowless:0.6.1’ which itself uses 'org.reactfx:reactfx:2.0-M5‘
Compiled with javafxmobile-plugin 2.0.29 it throws following runtime exception on iOS:

```
java.lang.AbstractMethodError: org.reactfx.collection.MemoizationListImpl$MemoizedView.isEmpty()Z
      at java.lang.Throwable.fillInStackTrace(Unknown Source)
      at java.lang.Throwable.<init>(Unknown Source)
      at java.lang.Error.<init>(Unknown Source)
      at java.lang.LinkageError.<init>(Unknown Source)
      at java.lang.IncompatibleClassChangeError.<init>(Unknown Source)
      at java.lang.AbstractMethodError.<init>(Unknown Source)
      at org.reactfx.util.FingerTree.mkTree(Unknown Source)
      at org.reactfx.collection.ListReduction.connect(Unknown Source)
      at org.reactfx.value.ValBase.observeInputs(Unknown Source)
      at org.reactfx.ObservableBase.addObserver(Unknown Source)
      at org.reactfx.value.Val.addInvalidationObserver(Unknown Source)
      at org.reactfx.value.Val.addListener(Unknown Source)
      at org.reactfx.value.Val.observeInvalidations(Unknown Source)
      at org.reactfx.value.OrElseConst.connect(Unknown Source)
      at org.reactfx.value.ValBase.observeInputs(Unknown Source)
      at org.reactfx.ObservableBase.addObserver(Unknown Source)
      at org.reactfx.value.Val.addInvalidationObserver(Unknown Source)
      at org.reactfx.value.Val.addListener(Unknown Source)
      at org.reactfx.value.Val$2.connect(Unknown Source)
      at org.reactfx.value.ValBase.observeInputs(Unknown Source)
      at org.reactfx.ObservableBase.addObserver(Unknown Source)
      at org.reactfx.value.Val.addInvalidationObserver(Unknown Source)
      at org.reactfx.value.Val.addListener(Unknown Source)
      at org.reactfx.value.Val$2.connect(Unknown Source)
      at org.reactfx.value.ValBase.observeInputs(Unknown Source)
      at org.reactfx.ObservableBase.addObserver(Unknown Source)
      at org.reactfx.ObservableBase.observe(Unknown Source)
      at org.reactfx.value.Val.observeInvalidations(Unknown Source)
      at org.reactfx.value.Val.pin(Unknown Source)
      at org.fxmisc.flowless.SizeTracker.<init>(Unknown Source)
      at org.fxmisc.flowless.VirtualFlow.<init>(Unknown Source)
      at org.fxmisc.flowless.VirtualFlow.createVertical(Unknown Source)
      at org.fxmisc.flowless.VirtualFlow.createVertical(Unknown Source)
      at net.joergwille.FlowlessTest.start(Unknown Source)
      at com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$9(Unknown Source)
      at com.sun.javafx.application.LauncherImpl$$Lambda$9.run(Unknown Source)
      at com.sun.javafx.application.PlatformImpl.lambda$runAndWait$11(Unknown Source)
      at com.sun.javafx.application.PlatformImpl$$Lambda$10.run(Unknown Source)
      at com.sun.javafx.application.PlatformImpl.lambda$runLater$9(Unknown Source)
      at com.sun.javafx.application.PlatformImpl$$Lambda$22.run(Unknown Source)
      at java.security.AccessController.doPrivileged(Unknown Source)
      at com.sun.javafx.application.PlatformImpl.lambda$runLater$10(Unknown Source)
      at com.sun.javafx.application.PlatformImpl$$Lambda$9.run(Unknown Source)
QuantumRenderer: shutdown
```

The error comes from following reactfx class:
/**
 * Plain boilerplate, because java.util.List does not have default methods.
 */
interface AccessorListMethods<E> extends List<E> {

    @override
    default boolean isEmpty() {
        return size() == 0;
    }
