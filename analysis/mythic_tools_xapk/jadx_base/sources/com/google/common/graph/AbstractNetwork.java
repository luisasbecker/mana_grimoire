package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractGraph<N> {

        /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1$1, reason: invalid class name and collision with other inner class name */
        class C01271 extends AbstractSet<EndpointPair<N>> {
            C01271() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AnonymousClass1.this.isOrderingCompatible(endpointPair) && AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) && AnonymousClass1.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function() { // from class: com.google.common.graph.AbstractNetwork$1$1$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return this.f$0.m10144lambda$iterator$0$comgooglecommongraphAbstractNetwork$1$1(obj);
                    }
                });
            }

            /* JADX INFO: renamed from: lambda$iterator$0$com-google-common-graph-AbstractNetwork$1$1, reason: not valid java name */
            /* synthetic */ EndpointPair m10144lambda$iterator$0$comgooglecommongraphAbstractNetwork$1$1(Object obj) {
                return AbstractNetwork.this.incidentNodes(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractNetwork.this.edges().size();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N n) {
            return AbstractNetwork.this.adjacentNodes(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            return AbstractNetwork.this.allowsParallelEdges() ? super.edges() : new C01271();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> incidentEdgeOrder() {
            return ElementOrder.unordered();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return AbstractNetwork.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return AbstractNetwork.this.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return AbstractNetwork.this.nodes();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N n) {
            return AbstractNetwork.this.predecessors((Object) n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N n) {
            return AbstractNetwork.this.successors((Object) n);
        }
    }

    private Predicate<E> connectedPredicate(final N n, final N n2) {
        return new Predicate<E>(this) { // from class: com.google.common.graph.AbstractNetwork.2
            final /* synthetic */ AbstractNetwork this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.base.Predicate
            public boolean apply(E e) {
                return this.this$0.incidentNodes(e).adjacentNode(n).equals(n2);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> network) {
        Set<E> setEdges = network.edges();
        Objects.requireNonNull(network);
        return Maps.asMap(setEdges, new Function() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda6
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return network.incidentNodes(obj);
            }
        });
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E e) {
        EndpointPair<N> endpointPairIncidentNodes = incidentNodes(e);
        return (Set<E>) edgeInvalidatableSet(Sets.difference(Sets.union(incidentEdges(endpointPairIncidentNodes.nodeU()), incidentEdges(endpointPairIncidentNodes.nodeV())), ImmutableSet.of((Object) e)), e);
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.graph.Network
    public int degree(N n) {
        return isDirected() ? IntMath.saturatedAdd(inEdges(n).size(), outEdges(n).size()) : IntMath.saturatedAdd(incidentEdges(n).size(), edgesConnecting(n, n).size());
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N n, N n2) {
        Set<E> setEdgesConnecting = edgesConnecting(n, n2);
        int size = setEdgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return setEdgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n, n2));
    }

    protected final <T> Set<T> edgeInvalidatableSet(Set<T> set, final E e) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda4
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return this.f$0.m10141xa0c212f3(e);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda5
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return String.format("Edge %s that was used to generate this set is no longer in the graph.", e);
            }
        });
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        Set<E> setOutEdges = outEdges(n);
        Set<E> setInEdges = inEdges(n2);
        return (Set<E>) nodePairInvalidatableSet(setOutEdges.size() <= setInEdges.size() ? Collections.unmodifiableSet(Sets.filter(setOutEdges, connectedPredicate(n, n2))) : Collections.unmodifiableSet(Sets.filter(setInEdges, connectedPredicate(n2, n))), n, n2);
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return isDirected() == network.isDirected() && nodes().equals(network.nodes()) && edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network));
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            return hasEdgeConnecting(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors((Object) n).contains(n2);
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N n) {
        return isDirected() ? inEdges(n).size() : degree(n);
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() == isDirected();
    }

    /* JADX INFO: renamed from: lambda$edgeInvalidatableSet$0$com-google-common-graph-AbstractNetwork, reason: not valid java name */
    /* synthetic */ Boolean m10141xa0c212f3(Object obj) {
        return Boolean.valueOf(edges().contains(obj));
    }

    /* JADX INFO: renamed from: lambda$nodeInvalidatableSet$2$com-google-common-graph-AbstractNetwork, reason: not valid java name */
    /* synthetic */ Boolean m10142xe136d8fa(Object obj) {
        return Boolean.valueOf(nodes().contains(obj));
    }

    /* JADX INFO: renamed from: lambda$nodePairInvalidatableSet$4$com-google-common-graph-AbstractNetwork, reason: not valid java name */
    /* synthetic */ Boolean m10143xa62961f6(Object obj, Object obj2) {
        return Boolean.valueOf(nodes().contains(obj) && nodes().contains(obj2));
    }

    protected final <T> Set<T> nodeInvalidatableSet(Set<T> set, final N n) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return this.f$0.m10142xe136d8fa(n);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return String.format("Node %s that was used to generate this set is no longer in the graph.", n);
            }
        });
    }

    protected final <T> Set<T> nodePairInvalidatableSet(Set<T> set, final N n, final N n2) {
        return InvalidatableSet.of((Set) set, (Supplier<Boolean>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda2
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return this.f$0.m10143xa62961f6(n, n2);
            }
        }, (Supplier<String>) new Supplier() { // from class: com.google.common.graph.AbstractNetwork$$ExternalSyntheticLambda3
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return String.format("Node %s or node %s that were used to generate this set are no longer in the graph.", n, n2);
            }
        });
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N n) {
        return isDirected() ? outEdges(n).size() : degree(n);
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
    }

    protected final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }
}
